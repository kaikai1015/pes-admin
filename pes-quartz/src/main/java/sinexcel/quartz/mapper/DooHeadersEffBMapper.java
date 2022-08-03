package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.DooHeadersEffBEO;

import java.util.List;

public interface DooHeadersEffBMapper {
    void deleteDooHeadersEffBEO(List<DooHeadersEffBEO> dooHeadersEffBEOS);

    void batchDooHeadersEffBEO(List<DooHeadersEffBEO> dooHeadersEffBEOS);
}
