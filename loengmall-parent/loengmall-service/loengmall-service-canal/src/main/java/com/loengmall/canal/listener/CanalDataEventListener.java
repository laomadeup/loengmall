package com.loengmall.canal.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.loeng.entity.Result;
import com.loengmall.content.feign.ContentFeign;
import com.loengmall.content.pojo.Content;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.DeleteListenPoint;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import com.xpand.starter.canal.annotation.ListenPoint;
import com.xpand.starter.canal.annotation.UpdateListenPoint;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author mapengliang
 * @createTime 2020/8/7 16:07
 * @desc cancal monitor mysql
 */
@CanalEventListener
public class CanalDataEventListener {

    @Autowired
    private ContentFeign contentFeign;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


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
   /* @InsertListenPoint
    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.printf("onEventInsert");
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("插入 列名:" + column.getName() + "--------变更的数据:" + column.getValue());
        }


    }*/

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
    /*@UpdateListenPoint
    public void onEventUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.printf("onEventUpdate");

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("修改前 列名:" + column.getName() + "--------变更前的数据:" + column.getValue());
        } for (CanalEntry.Column column : afterColumnsList) {
            System.out.println("修改后 列名:" + column.getName() + "--------变更后的值:" + column.getValue());
        }
    }*/

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
   /* @DeleteListenPoint
    public void onEventDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.printf("onEventDelete");

        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("删除 列名:" + column.getName() + "--------删除的数据:" + column.getValue());
        }
    }*/


    /**
     * <p>自定义数据库的监听来操作</p>
     * <p>
     * * @param eventType
     *
     * @param rowData
     * @return void
     * @author mapengliang
     * @createTime 2020/8/13 16:30
     */
    @ListenPoint(destination = "example", schema = "loengmall_content", table = {"tb_content", "tb_content_category"}
            , eventType = {CanalEntry.EventType.UPDATE, CanalEntry.EventType.DELETE, CanalEntry.EventType.INSERT})
    public void onEventCustomUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.println("onEventCustomUpdate");
        String categoryId = getColumnValue(eventType, rowData);
        System.out.println("categoryId:"+categoryId);
        Result<List<Content>> resultContents = contentFeign.findByCategory(Long.valueOf(categoryId));

        List<Content> contents = resultContents.getData();
        //使用redisTemplate存储到redis中
        stringRedisTemplate.boundValueOps("content_"+categoryId).set(JSON.toJSONString(contents));
    }

    private String getColumnValue(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

        String categoryId = "";
        if (CanalEntry.EventType.DELETE == eventType) {
           /* Optional<CanalEntry.Column> optionalColumn = rowData.getBeforeColumnsList().stream().filter(column -> StringUtils.equalsIgnoreCase(column.getName(), "category_id")).findFirst();
            return optionalColumn.orElse((CanalEntry.Column) new Object()).getValue();*/
            List<CanalEntry.Column> columnData = rowData.getBeforeColumnsList();
            for (int i = 0; i < columnData.size(); i++) {
                if(StringUtils.equalsIgnoreCase(columnData.get(i).getName(),"category_id")){
                    return columnData.get(i).getValue();
                }
            }
            return categoryId;
        } else {
            List<CanalEntry.Column> columnData = rowData.getAfterColumnsList();
            for (int i = 0; i < columnData.size(); i++) {
                if(StringUtils.equalsIgnoreCase(columnData.get(i).getName(),"category_id")){
                    return columnData.get(i).getValue();
                }
            }
//            return rowData.getAfterColumnsList().stream().filter(column -> StringUtils.equalsIgnoreCase(column.getName(), "category_id")).map(CanalEntry.Column::getValue).findAny().orElse("");

        }
        return categoryId;
    }

}
