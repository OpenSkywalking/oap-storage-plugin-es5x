/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.storage.plugin.elasticsearch5x.base;

import java.io.IOException;
import org.apache.skywalking.oap.server.core.analysis.indicator.Indicator;
import org.apache.skywalking.oap.server.core.storage.IHistoryDeleteDAO;
import org.apache.skywalking.oap.server.storage.plugin.elasticsearch5x.client.ElasticSearchClient5x;
import org.slf4j.*;

/**
 * @author peng-yongsheng
 */
public class HistoryDeleteEsDAO extends EsDAO implements IHistoryDeleteDAO {

    private static final Logger logger = LoggerFactory.getLogger(HistoryDeleteEsDAO.class);

    public HistoryDeleteEsDAO(ElasticSearchClient5x client) {
        super(client);
    }

    @Override
    public void deleteHistory(String modelName, String timeBucketColumnName, Long timeBucketBefore) throws IOException {
        int statusCode = getClient().delete(modelName, timeBucketColumnName, timeBucketBefore);
        if (logger.isDebugEnabled()) {
            logger.debug("Delete history from {} index, status code {}", modelName, statusCode);
        }
    }
}
