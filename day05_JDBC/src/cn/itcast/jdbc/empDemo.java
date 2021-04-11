package cn.itcast.jdbc;

import cn.itcast.domain.emp;
import cn.itcast.util.JDBCUtil;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empDemo {
    public static void main(String[] args) throws Exception{
        Connection coon=null;
        Statement stms=null;
        ResultSet result=null;
        List<emp> list=new ArrayList<emp>();


        try {
             coon=JDBCUtil.getConnection();
            String sql="select * from emp";
            stms=coon.createStatement();

             result=stms.executeQuery(sql);
            System.out.println(result);


            //处理结果
            while(result.next()){
                int id=result.getInt(1);
                String name=result.getString("name");
                String gender=result.getString(3);
                double salary=result.getDouble(4);
                Date date=result.getDate(5);
                int dept_id=result.getInt(6);

                emp em=new emp();
                em.setId(id);
                em.setDept_id(dept_id);
                em.setGender(gender);
                em.setJoin_date(date);
                em.setName(name);
                em.setSalary(salary);

                list.add(em);



            }
            for(emp em1:list){
                System.out.println(em1.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
         JDBCUtil.close(result,stms,coon);
    }

    }
}
