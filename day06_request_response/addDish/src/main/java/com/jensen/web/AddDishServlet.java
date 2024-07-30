package com.jensen.web;

import com.jensen.dao.DishMapper;
import com.jensen.pojo.Dish;
import com.jensen.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDishServlet")
public class AddDishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        System.out.println(name);
        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setDescription(description);

        SqlSession sqlSession = MyBatisUtil.openSession (true);
        DishMapper mapper = sqlSession.getMapper(DishMapper.class);
        mapper.addDish(dish);

        response.getWriter().print("success");
    }
}
