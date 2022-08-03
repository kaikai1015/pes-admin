package sinexcel.common.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import sinexcel.common.constant.HttpStatus;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.core.domain.entity.SysRole;
import sinexcel.common.core.domain.entity.SysUser;
import sinexcel.common.core.page.PageDomain;
import sinexcel.common.core.page.TableDataInfo;
import sinexcel.common.core.page.TableSupport;
import sinexcel.common.utils.DateUtils;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.common.utils.StringUtils;
import sinexcel.common.utils.sql.SqlUtil;

/**
 * web层通用数据处理
 * 
 * @author pes
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * @Author mingshen.wang
     * @Description
     * @Date 11:01 2021/10/14
     * @Param []
     * @return java.lang.Long
     **/
    public static Long getWwAuthByDept(){
        SysUser user = SecurityUtils.getLoginUser().getUser();
        //判断是否有超级管理员
        long[] roleIds = new  long[]{};
        if (user.getRoles()!=null&&user.getRoles().size()>0){
            roleIds = user.getRoles().stream().mapToLong(SysRole::getRoleId).toArray();
        }
//        if (user.isAdmin()|| !ArrayUtils.contains(roleIds,22L) ){
        if (user.isAdmin()|| !ArrayUtils.contains(user.getRoleIds(),26L) ){
            return null;
        }else {
            if (user.getDeptId() == null){
                return 0L;
            }else {
                return  user.getDeptId();
            }

        }
    }
}
