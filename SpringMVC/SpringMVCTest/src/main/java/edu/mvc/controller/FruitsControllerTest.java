package edu.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.mvc.model.*;

// 配合非注解的处理器适配器---1：SimpleControllerHandlerAdapter
public class FruitsControllerTest implements Controller{
    private FruitsService fruitsService = new FruitsService();

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 模拟Service获取水果商品列表
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitsList", fruitsList);
        // 指定视图
        // ！以WEB-INF为基准
        modelAndView.setViewName("/WEB-INF/jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
    
}

class FruitsService {
    public List<Fruits> queryFruitsList() {
        List<Fruits> fruitsList = new ArrayList<Fruits>();

        Fruits apple = new Fruits();
        apple.setName("红富士苹果");
        apple.setPrice(4.5);
        apple.setProducing_area("山东");

        Fruits banana = new Fruits();
        banana.setName("进口香蕉");
        banana.setPrice(3.5);
        banana.setProducing_area("泰国");

        fruitsList.add(apple);
        fruitsList.add(banana);
        return fruitsList;
    }
}
