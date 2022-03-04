package hi.practice.autowired;

import hi.practice.menu.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        @Autowired(required = false) // 의존관계가 없기 때문에 메소드 자체가 호출되지 않음
        public void setNoBean1(Menu noBean1){ //스프링 컨테이너에 없는 것
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Menu noBean2){ //스프링 컨테이너에 없는 것
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Menu> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
