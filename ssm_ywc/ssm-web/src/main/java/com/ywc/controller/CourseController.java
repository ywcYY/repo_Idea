package com.ywc.controller;

import com.ywc.domain.Course;
import com.ywc.domain.CourseVO;
import com.ywc.domain.ResponseResult;
import com.ywc.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//相当于@Controller + @Res
@RequestMapping("/course")

public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("findCourseByCondition")
    public ResponseResult responseResult(@RequestBody CourseVO courseVO){

        List<Course> courseByCondition = courseService.findCourseByCondition(courseVO);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", courseByCondition);

        return result;


    }
    /*课程图片上传*/
    @RequestMapping("/courseUpload")

    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //1.判断接受到的上传文件是否为空

            if (file.isEmpty()) {
                throw new RuntimeException();

            }
            //2.获取项目的部署路径
            //tomcat的webapp下
            String realPath = request.getServletContext().getRealPath("/");
            String substring = realPath.substring(0, realPath.indexOf("ssm-web"));
            //3,获取原文件名
            String originalFilename = file.getOriginalFilename();
            //4.生成新文件名
            String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            String uploadPath = substring + "upload\\";
            File filePath = new File(uploadPath, newFileName);
            //如果目录不存在则创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);

            }

            file.transferTo(filePath);

//6.将文件名和文件路径进行返回，进行响应

            Map<String, String> map = new HashMap<>();
            map.put("fileName", newFileName);
            map.put("filePath", "http://localhost:8080/upload/" + newFileName);

            ResponseResult result = new ResponseResult(true, 200, "图片上传成功", map);

            return result;

        }
@RequestMapping("/saveOrUpdateCourse")
        public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        if(courseVO.getId()==null){

        courseService.saveCourseOrTeacher(courseVO);
            ResponseResult result1 = new ResponseResult(true, 200, "响应成功", null);
            return  result1;
        }
        else {

            courseService.updateCourseOrTeacher(courseVO);
            ResponseResult result2 = new ResponseResult(true, 200, "响应成功", null);
            return  result2;
        }





}
@RequestMapping("/findCourseById")
        public ResponseResult findCourseById(Integer id){


    CourseVO courseVO = courseService.findCourseById(id);
    ResponseResult result = new ResponseResult(true, 200, "响应成功", courseVO);
    return  result;


}



@RequestMapping("updateCourseStatus")
public ResponseResult updateCourseStatus(@RequestParam Integer id,Integer status){



        courseService.updateCourseStatus(id,status);

    Map<String, Object> map =new HashMap<>();
    map.put("status",status);
    ResponseResult result = new ResponseResult(true, 200, "状态更改响应成功",map);
        return  result;


}
    }







