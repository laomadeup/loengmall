package com.loengmall.canal;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.DeleteListenPoint;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import com.xpand.starter.canal.annotation.ListenPoint;
import com.xpand.starter.canal.annotation.UpdateListenPoint;

import java.util.List;

/**
 * @author mapengliang
 * @createTime 2020/8/7 16:07
 * @desc cancal monitor mysql
 */
@CanalEventListener
public class CanalDataEventListener {

    /**
     * <p>监听数据新增</p>
     * <p>
     * * @param eventType
     *
     * @param rowData
     * @return void
     * @author mapengliang
     * @createTime 2020/8/7 16:50
     */
    @InsertListenPoint
    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("插入 列名:" + column.getName() + "--------变更的数据:" + column.getValue());
        }


    }

    /**
     * <p>监听数据修改</p>
     * <p>
     * * @param eventType
     *
     * @param rowData
     * @return void
     * @author mapengliang
     * @createTime 2020/8/7 16:53
     */
    @UpdateListenPoint
    public void onEventUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("修改前 列名:" + column.getName() + "--------变更前的数据:" + column.getValue());
        } for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("修改后 列名:" + column.getName() + "--------变更后的值:" + column.getValue());
        }
    }

    /**
     * <p>监听数据删除</p>
     * <p>
     * * @param eventType
     *
     * @param rowData
     * @return void
     * @author mapengliang
     * @createTime 2020/8/7 16:53
     */
    @DeleteListenPoint
    public void onEventDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("删除 列名:" + column.getName() + "--------删除的数据:" + column.getValue());
        }
    }


    @ListenPoint(destination = "example",schema ="loengmall_content",table = {"tb_content","tb_content_category"}
                ,eventType = {CanalEntry.EventType.UPDATE, CanalEntry.EventType.DELETE})
    public void onEventCustomUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("====自定义操作前 列名:" + column.getName() + "--------变更的数据:" + column.getValue());
        }
        for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("====自定义操作后 列名:" + column.getName() + "--------变更的数据:" + column.getValue());

        }

    }

}
