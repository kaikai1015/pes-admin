package sinexcel.web.controller.oa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinexcel.common.annotation.Log;
import sinexcel.common.annotation.RepeatSubmit;
import sinexcel.common.core.controller.BaseController;
import sinexcel.common.core.domain.AjaxResult;
import sinexcel.common.enums.BusinessType;
import sinexcel.items.domain.CuxWorkSubstitutedMaterial;
import sinexcel.items.service.ICuxWorkSubstitutedMaterialService;

/**
 * 物料替代信息Controller
 *
 * @author Zhang Kai
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/oa/substituted")
public class CuxOAWorkSubstitutedMaterialController extends BaseController
{
    @Autowired
    private ICuxWorkSubstitutedMaterialService cuxWorkSubstitutedMaterialService;

    /**
     * 新增物料替代信息
     */
//    @PreAuthorize("@ss.hasPermi('items:substituted:addBatch')")
    @Log(title = "批量物料替代信息", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    @RepeatSubmit
    public AjaxResult addBatch(@RequestBody List<CuxWorkSubstitutedMaterial> infoList)
    {
        return cuxWorkSubstitutedMaterialService.inserBatchtCuxWorkSubstitutedMaterial(infoList);
    }
}
