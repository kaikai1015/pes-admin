package sinexcel.quartz.mapper;

import sinexcel.quartz.domain.MesPoReturnVendorAllEO;

import java.util.List;

public interface MesPoReturnVendorAllMapper {
    public List<MesPoReturnVendorAllEO> getPoReturnVendorList(MesPoReturnVendorAllEO mesPoReturnVendorAll);

    public int updateErpFlag(MesPoReturnVendorAllEO mesPoReturnVendorAll);

    public int getWieOrderList(MesPoReturnVendorAllEO poReturnVendorList);

    public MesPoReturnVendorAllEO selectOrgnazationCode(Long organizationId);

    public List<MesPoReturnVendorAllEO> selectOperSequenceNumber(MesPoReturnVendorAllEO poReturnVendorList);

    public int updateErpFlagWork(MesPoReturnVendorAllEO poReturnVendorList);

    MesPoReturnVendorAllEO selectMesPoReturnVendorAllById(Long returnVendorId);

    List<MesPoReturnVendorAllEO> selectMesPoReturnVendorAllList(MesPoReturnVendorAllEO mesPoReturnVendorAll);
}
