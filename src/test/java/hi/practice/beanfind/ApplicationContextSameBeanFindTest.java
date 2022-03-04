package hi.practice.beanfind;

import hi.practice.menu.MemoryMenuRepository;
import hi.practice.menu.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면 중복 오류 발생")
    void findBeanByTypeDuplication(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()->
                ac.getBean(MenuRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면 빈 이름을 지정한다.")
    void findBeanByName(){
        MenuRepository menuRepository = ac.getBean("menuRepository1", MenuRepository.class);
        assertThat(menuRepository).isInstanceOf(MenuRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType(){
        Map<String, MenuRepository> beansOfType = ac.getBeansOfType(MenuRepository.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MenuRepository menuRepository1(){
            return new MemoryMenuRepository();
        }

        @Bean
        public MenuRepository menuRepository2(){
            return new MemoryMenuRepository();
        }
    }
}
