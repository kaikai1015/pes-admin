package sinexcel.items.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinexcel.common.constant.UserConstants;
import sinexcel.common.utils.ConfigUtils;
import sinexcel.common.utils.InSoapUtil;
import sinexcel.common.utils.SecurityUtils;
import sinexcel.items.mapper.CuxItemBomChoMapper;
import sinexcel.items.domain.CuxItemBomCho;
import sinexcel.items.service.ICuxItemBomChoService;
import sinexcel.utils.InBomSoapUtil;

/**
 * BOM选配物料结构Service业务层处理
 * 
 * @author Zhang Kai
 * @date 2020-12-27
 */
@Service
public class CuxItemBomChoServiceImpl implements ICuxItemBomChoService 
{

    @Autowired
    private CuxItemBomChoMapper cuxItemBomChoMapper;


    /**
     * 查询BOM选配物料结构
     * 
     * @param choId BOM选配物料结构ID
     * @return BOM选配物料结构
     */
    @Override
    public CuxItemBomCho selectCuxItemBomChoById(Long choId)
    {
        return cuxItemBomChoMapper.selectCuxItemBomChoById(choId);
    }

    /**
     * 查询BOM选配物料结构列表
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return BOM选配物料结构
     */
    @Override
    public List<CuxItemBomCho> selectCuxItemBomChoList(CuxItemBomCho cuxItemBomCho)
    {
        return cuxItemBomChoMapper.selectCuxItemBomChoList(cuxItemBomCho);
    }

    /**
     * 新增BOM选配物料结构
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    @Transactional
    public int insertCuxItemBomCho(CuxItemBomCho cuxItemBomCho)
    {
        if(cuxItemBomCho.getpInventoryItemId().equals(cuxItemBomCho.getRootId())){
            cuxItemBomCho.setpInventoryItemId(0l);
        }
        cuxItemBomCho.setCreateBy(SecurityUtils.getUsername());
        return cuxItemBomChoMapper.insertCuxItemBomCho(cuxItemBomCho);
    }

    /**
     * 修改BOM选配物料结构
     * 
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    @Override
    @Transactional
    public int updateCuxItemBomCho(CuxItemBomCho cuxItemBomCho)
    {
        cuxItemBomCho.setCreateBy(SecurityUtils.getUsername());
        return cuxItemBomChoMapper.updateCuxItemBomCho(cuxItemBomCho);
    }

    /**
     * 批量删除BOM选配物料结构
     * 
     * @param choIds 需要删除的BOM选配物料结构ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteCuxItemBomChoByIds(Long choIds)
    {
        int h;
        h = cuxItemBomChoMapper.deleteCuxItemBomChoByIds(choIds);
        if(h > 0){
            List<CuxItemBomCho> subItems= cuxItemBomChoMapper.selectIdTrees(choIds);
            if (subItems.size() > 0) {
                CuxItemBomCho childId = new CuxItemBomCho();
                for (int i = 0; i < subItems.size(); i++) {
                    childId.setChoId(subItems.get(i).getChoId());
                    deleteCuxItemBomChoByIds(childId.getChoId());
                }
            }
        }
        return h;
    }

    /**
     * 展开BOM选配物料结构
     *
     * @param cuxItemBomCho,organizationId BOM选配物料结构
     * @return 结果
     */
    @Override
    public int getValue(CuxItemBomCho cuxItemBomCho)
    {
        int k = 0;
        List<CuxItemBomCho> items =cuxItemBomChoMapper.selectItemTrees(cuxItemBomCho);
        if (items.size()>0) {
            CuxItemBomCho items1 = new CuxItemBomCho();
            for (int i = 0; i < items.size(); i++) {
                insertCuxItemBomCho(items.get(i));
                if(items.get(i).getItemType().equals("CHO")){
                    items1.setpInventoryItemId(items.get(i).getInventoryItemId());
                    items1.setOrganizationId(items.get(i).getOrganizationId());
                    items1.setOrgItemId(items.get(i).getOrgItemId());
                    items1.setRootId(items.get(i).getRootId());
                    getValue(items1);
                }
                k++;
            }
        }
        return k;
    }

    /**
     * 添加OM选配组件物料
     *
     * @param cuxItemBomCho BOM选配物料结构
     * @return 结果
     */
    @Override
    @Transactional
    public int insertCuxSubItemBomCho(CuxItemBomCho cuxItemBomCho)
    {
        CuxItemBomCho subItem = cuxItemBomChoMapper.getSubItemInfor(cuxItemBomCho);
        cuxItemBomCho.setInventoryItemId(subItem.getInventoryItemId());
        cuxItemBomCho.setItemDescription(subItem.getItemDescription());
        cuxItemBomCho.setItemType(subItem.getItemType());
        cuxItemBomCho.setCreateBy(SecurityUtils.getUsername());
        return cuxItemBomChoMapper.insertCuxItemBomCho(cuxItemBomCho);
    }

    /**
     * 校验组件编码是否唯一
     *
     * @param cuxItemBomCho
     * @return 结果
     */
    @Override
    public String checkSubItemNumberUnique(CuxItemBomCho cuxItemBomCho)
    {
        int count = cuxItemBomChoMapper.checkSubItemNumberUnique(cuxItemBomCho);
        if (count > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 提交ERP按钮操作
     *
     * @param cuxItemBomCho 提交ERP按钮操作
     * @return 结果
     */
    @Override
    public int submitErp(CuxItemBomCho cuxItemBomCho)
    {
        int k = 0;
        String lineDetails = "";
        String orgCode [] = new String[]{"INV_SH_X","INV_HZSH","INV_SHENZHEN_HZ_X"};
        List<CuxItemBomCho> itemsInfor =cuxItemBomChoMapper.selectCuxItemBomChoList(cuxItemBomCho);
        if(itemsInfor.size() > 0)
        {
            for(CuxItemBomCho subItem : itemsInfor)
            {
            if(!subItem.getItemType().equals("CHO")){
                lineDetails += "        <str:Component>\n" +
                        "            <str:ComponentItemNumber>"+subItem.getItemNumber()+"</str:ComponentItemNumber>\n" +
                        "            <str:Quantity>"+subItem.getComponentQuantity()+"</str:Quantity>\n" +
                        "        </str:Component>\n";
            }
        }
        for(int i = 0;i < orgCode.length; i++){
            CuxItemBomCho getHeaderItems =cuxItemBomChoMapper.getHeaderList(cuxItemBomCho);
            try {
            String xmlStr = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/scm/productModel/items/structures/structureServiceV2/types/\" xmlns:str=\"http://xmlns.oracle.com/apps/scm/productModel/items/structures/structureServiceV2/\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <typ:createStructure>\n" +
                    "      <typ:structure>\n" +
                    "        <str:OrganizationCode>"+orgCode[i]+"</str:OrganizationCode>\n" +
                    "        <str:ItemNumber>"+getHeaderItems.getItemNumber()+"</str:ItemNumber>\n" +
                    "        <str:StructureName>Primary</str:StructureName>\n" +
                    "        <str:EffectivityControlValue>Date</str:EffectivityControlValue>\n" +
                    lineDetails +
                    "      </typ:structure>\n" +
                    "      </typ:createStructure>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            String scode = InBomSoapUtil.analysisXML(InSoapUtil.callSoapWSUrlTransData(xmlStr, ConfigUtils.getItemBomUrl(),ConfigUtils.getItemBomName(),ConfigUtils.getItemBomMethodName()));
            if(scode.length() == 15 ? true : false){
                cuxItemBomChoMapper.updateErpFlag(cuxItemBomCho);
               k++;
            }else {
                getHeaderItems.setErrorInfor(scode);
                getHeaderItems.setOrganizationCode(orgCode[i]);
                getHeaderItems.setCreateBy(SecurityUtils.getUsername());
                k = 0;
                cuxItemBomChoMapper.inertErrorInfor(getHeaderItems);
            }
            } catch (Exception e) {
                getHeaderItems.setOrganizationCode(orgCode[i]);
                getHeaderItems.setCreateBy(SecurityUtils.getUsername());
                getHeaderItems.setErrorInfor(e.getMessage());
                k = 0;
                cuxItemBomChoMapper.inertErrorInfor(getHeaderItems);
            }
        }
        }
        return k;
    }
}
