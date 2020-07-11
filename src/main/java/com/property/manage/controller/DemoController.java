package com.property.manage.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.property.manage.dao.model.User;
import com.property.manage.dao.model.excel.UserExcel;
import com.property.manage.service.UserServiceImple;
import com.property.manage.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DemoController
 * @description: 本项目的示例controller类
 * @author: sunzhengwei
 * @create: 2020/7/9 16:00
 */
@RestController
@RequestMapping("/demoproject/demo")
public class DemoController {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserServiceImple userService ;

    @RequestMapping(value = "/export/excel",method= RequestMethod.POST,produces = ("application/json;charset=UTF-8"))
    void getCdEvaluateTemplateQuestsExcel(ModelMap map, HttpServletRequest request, HttpServletResponse response) {

        List<UserExcel> list = new ArrayList<>();

        List<User> listUser = userService.getAllUser();
        for (User user : listUser) {
            UserExcel userExcel = new UserExcel();
            try {
                BeanUtils.applyIf(userExcel, user);
            }catch (Exception e){
                logger.error(e.getMessage(), e);
            }
            list.add(userExcel);
        }
        ExportParams params = new ExportParams("导出列表", "表1", ExcelType.XSSF);
        // params.setFreezeCol(2);
        map.put(NormalExcelConstants.DATA_LIST, list);
        map.put(NormalExcelConstants.CLASS, UserExcel.class);
        map.put(NormalExcelConstants.PARAMS, params);
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
