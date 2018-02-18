package com.cjs.jworks.generator.db;

import com.cjs.jworks.generator.BaseTest;
import com.cjs.jworks.generator.db.base.DBManager;
import com.cjs.jworks.generator.db.impl.DBManagerImpl;
import org.junit.Test;

public class DBManagerImplTest extends BaseTest {

    @Test
    public void testFieldsMeta() throws Exception {
        final DBManager dbManager = new DBManagerImpl(getContext());
        dbManager.execute("CREATE TABLE `Case` (\n" +
                "  `case_id_seq` int(11) NOT NULL,\n" +
                "  `case_name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`case_id_seq`)\n" +
                ")");
        dbManager.getTableMeta("Case");
    }
}
