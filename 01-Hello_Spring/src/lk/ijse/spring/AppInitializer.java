package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.BasicDataSource;
import lk.ijse.spring.pojo.DBConnection;
import lk.ijse.spring.pojo.ItemController;
import lk.ijse.spring.pojo.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*desktop application ekata deela thiyena object eka - AnnotationConfigApplicationContext */
public class AppInitializer {
    public static void main(String args[]){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        SpringBean bean = ctx.getBean(SpringBean.class);
        bean.test();  /*return a method in a Bean class*/
        System.out.println(bean);  /*object eke address eka return wenwa*/

        DBConnection con = ctx.getBean(DBConnection.class);
        con.getConnection();
        System.out.println(con);

        /*========Access the class, which we didn't create================*/
        BasicDataSource bean2 = ctx.getBean(BasicDataSource.class);
        bean2.accessPool();

        ItemController itemBean = (ItemController) ctx.getBean("item");
        System.out.println(itemBean);

        BasicDataSource bean1 = (BasicDataSource) ctx.getBean("basic");
        bean1.accessPool();
        System.out.println(bean1);

        ctx.close();
    }
}
