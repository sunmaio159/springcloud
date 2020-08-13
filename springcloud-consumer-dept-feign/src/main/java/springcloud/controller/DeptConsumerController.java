package springcloud.controller;

import com.sun.springcloud.pojo.entity.Dept;
import com.sun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private DeptService service = null;
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id);
    }
    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return service.addDept(dept);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        return service.queryAll();
    }
}
