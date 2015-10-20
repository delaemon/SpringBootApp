package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.Configurations;
import com.example.ConfigurationsRepository;
 
@Controller
@EnableAutoConfiguration
public class HelloController {
	
    @Autowired
    ConfigurationsRepository configurationsRepository;
 
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("[START] データベースに接続してデータを取得します。");
        Page<Configurations> configs = configurationsRepository.findAll(new PageRequest(0, 10));
        for (Configurations config : configs) {
            System.out.println(config.getName() + " = " + config.getValue());
        }
        System.out.println("[END  ] データベースに接続してデータを取得します。");

        ArrayList<ViewData> list = new ArrayList<ViewData>();
        for (int i = 0; i < 5; i++) {
            ViewData data = new ViewData();
            StringBuffer buffer = new StringBuffer();
            buffer.append("メッセージ");
            buffer.append(i);
            data.setNo(i + 1);
            data.setMessage(buffer.toString());
            list.add(data);
        }
 
        model.addAttribute("msg", list);
        return "index";
    }
}
 
class ViewData {
    private int no;
    private String message;
 
    public int getNo() {
        return no;
    }
 
    public void setNo(int no) {
        this.no = no;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String toString() {
        return message;
    }
}