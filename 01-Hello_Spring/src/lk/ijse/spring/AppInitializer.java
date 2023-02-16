package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.SpringBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*desktop application ekata deela thiyena object eka - AnnotationConfigApplicationContext */
public class AppInitializer {
    public static void main(String args[]){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        SpringBean bean = ctx.getBean(SpringBean.class);
        SpringBean bean1 = ctx.getBean(SpringBean.class);
      /*  bean.test();  *//*return a method in a Bean class*//*
        System.out.println(bean);  *//*object eke address eka return wenwa*/

        /*check same reference or not*/
        System.out.println(bean);
        System.out.println(bean1);

        ctx.close();
    }
}
