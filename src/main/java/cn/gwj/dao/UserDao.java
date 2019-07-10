package cn.gwj.dao;
/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.dao
    User:1093499975@qq.com
    Date:2019/7/9 0009
    Time:14:27
*/

import cn.gwj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int count();
    List<User> selectAll();
    List<User> selectUserByName(String name);
    int add(User user);
    int modify(User user);
    int updatePwd(@Param("id") int id,@Param("pwd")String password);
    int deleteUserById(int id);
    List<User> getUserList(@Param("userName") String userName,@Param("userRole") int userRole,@Param("currentPageNo") int currentPageNo,@Param("PageSize") int PageSize);
}
