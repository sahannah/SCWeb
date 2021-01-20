package mvc.handler;

import entity.Admin;
import entity.ParamData;
import entity.Student;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.AdminService;
import util.CrowdUtil;
import util.ResultEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestHandler {
    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap, HttpServletRequest request){
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        logger.debug("judgeResult:"+judgeResult);
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
//        String a = null;
//        System.out.println(a.length());
        System.out.println(10/0);
        return "target";
    }

    @ResponseBody
    @RequestMapping("/send/array/one.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array){
        for(Integer i : array){
            logger.debug("number"+i);
        }
        return "success";

    }
    @ResponseBody
    @RequestMapping("/send/array/two.html")
    public String testReceiveArrayTwo(ParamData paramData){
        List<Integer> array = paramData.getArray();
        for(Integer i : array){
            logger.debug("number"+i);
        }
        return "success";

    }

    @ResponseBody
    @RequestMapping("/send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array){
        for(Integer i : array){
            logger.debug("number"+i);
        }
        return "success";

    }

    @ResponseBody
    @RequestMapping("/send/complex/object.json")
    public ResultEntity<Student> testReceiveComplexObject(@RequestBody Student student, HttpServletRequest request){
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        logger.debug("judgeResult:"+judgeResult);
        logger.debug(student.toString());
        String a = null;
        System.out.println(a.length());
        return ResultEntity.successWithData(student);
    }


}
