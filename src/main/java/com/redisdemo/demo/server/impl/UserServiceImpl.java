package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.controller.BaseFrontController;
import com.redisdemo.demo.dao.UserMapper;
import com.redisdemo.demo.dto.UserDTO;
import com.redisdemo.demo.entity.User;
import com.redisdemo.demo.query.UserQuery;
import com.redisdemo.demo.server.UserService;
import com.redisdemo.demo.utils.ExcelUtils;
import com.redisdemo.demo.vo.UserVO;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(UserQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = userMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<UserVO> getAll(UserQuery userQuery) {
    	return userMapper.getAll(userQuery);
    }


    @Override
    public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> map) {
        try {
            UserQuery userQuery = new UserQuery();
            if (null != map.get("username") && !"".equals(map.get("username"))){
                userQuery.setAccountNumber(map.get("username").toString());
            }
            if (null != map.get("name") && !"".equals(map.get("name"))){
                userQuery.setName(map.get("name").toString());
            }
            if (null != map.get("password") && !"".equals(map.get("password"))){
                userQuery.setPassword(map.get("password").toString());
            }
            List<UserVO> all = userMapper.getAll(userQuery);
            BaseFrontController baseFrontController = new BaseFrontController();
            return baseFrontController.buildResponseEntity(export((List<UserVO>) all), "用户信息.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }








    @Override
    public UserVO getOne(UserQuery query) {
        return userMapper.getOne(query);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public User getById(Integer id) {
        User byId = userMapper.getById(id);
        return byId;
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param userdto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(UserDTO userdto) {
    	return userMapper.add(userdto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param userdto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(UserDTO userdto) {
    	return userMapper.updateById(userdto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return userMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return userMapper.deleteByIds(ids);
    }







    private InputStream export(List<UserVO> list) {
        ByteArrayOutputStream output = null;
        InputStream inputStream1 = null;
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);// 保留1000条数据在内存中
        SXSSFSheet sheet = wb.createSheet();
        // 设置报表头样式
        CellStyle header = ExcelUtils.headSytle(wb);// cell样式
        CellStyle content = ExcelUtils.contentStyle(wb);// 报表体样式


        // title
        String[] strs = new String[]
                { "id", "用户名称", "账号", "密码",
                        "创建时间","修改时间", "创建人", "修改人"};

        // 字段名所在表格的宽度
        int[] ints = new int[] { 5000, 5000, 5000, 5000, 5000,
                5000, 5000, 5000, 5000, 5000};

        // 设置表头样式
        ExcelUtils.initTitleEX(sheet, header, strs, ints);

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                UserVO user = list.get(i);

                SXSSFRow row = sheet.createRow(i + 1);
                int j = 0;

                SXSSFCell cell = row.createCell(j++);
                cell.setCellValue(user.getId()); // id
                cell.setCellStyle(content);

                cell = row.createCell(j++);
                cell.setCellValue(user.getName()); // 名称
                cell.setCellStyle(content);

                cell = row.createCell(j++);
                cell.setCellValue(user.getAccountNumber()); // 账号
                cell.setCellStyle(content);

                cell = row.createCell(j++);
                cell.setCellValue(user.getPassword()); // 密码
                cell.setCellStyle(content);


                cell = row.createCell(j++);
                cell.setCellValue(user.getCreateTime()); // 创建时间
                cell.setCellStyle(content);


                cell = row.createCell(j++);
                cell.setCellValue(user.getUodateTime()); // 修改时间
                cell.setCellStyle(content);


                cell = row.createCell(j++);
                cell.setCellValue(user.getCreatePeople()); // 创建人
                cell.setCellStyle(content);


                cell = row.createCell(j++);
                cell.setCellValue(user.getUodatePeople()); // 修改人
                cell.setCellStyle(content);


            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>结束遍历数据组装单元格内容>>>>>>>>>>");
        }
        try {
            output = new ByteArrayOutputStream();
            wb.write(output);
            inputStream1 = new ByteArrayInputStream(output.toByteArray());
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (output != null) {
                    output.close();
                    if (inputStream1 != null) {
                        inputStream1.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return inputStream1;
    }
}