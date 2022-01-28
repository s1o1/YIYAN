package com.gzj.dao.mapper;

import com.gzj.dao.pojo.Pic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PicMapper {
    @Select("select * from pics ")
    List<Pic> getPics();

    /**
     *               向数据库添加图片
     * @param pic    图片
     */
    @Insert("insert into pics values(#{id},#{name},#{createTime},#{suffix},#{url},#{type})")
    void addPic(Pic pic);

    /**
     *                 分页查询
     * @param index    起始页
     * @param length   长度
     * @param type     图片类型
     * @return         查询结果
     */
    @Select("select * from pics where type = #{type} order by create_time desc limit #{index},#{length} ")
    List<Pic> getPic(int index, int length,String type);

    /**
     *          查询所有记录的数量
     * @param type     图片类型
     * @return  记录的数量
     */
    @Select("select count(id) from pics where type = #{type}")
    int getPicNums(String type);

    /**
     *              通过图片名字查询图片url
     * @param name  图片名字
     * @return      图片url
     */
    @Select("select url from pics where name = #{name}")
    String queryUrlByName(String name);

    /**
     * 通过名字删除图片
     * @param name   图片名称
     */
    @Select("delete from pics where name = #{name}")
    void delPicByName(String name);
}
