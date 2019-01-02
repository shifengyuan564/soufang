package com.imooc.soufang.service.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.soufang.entity.form.MapSearch;
import com.imooc.soufang.entity.form.RentSearch;
import com.imooc.soufang.repository.HouseDetailRepository;
import com.imooc.soufang.repository.HouseRepository;
import com.imooc.soufang.repository.HouseTagRepository;
import com.imooc.soufang.repository.SupportAddressRepository;
import com.imooc.soufang.service.ServiceMultiResult;
import com.imooc.soufang.service.ServiceResult;
import com.imooc.soufang.service.house.IAddressService;
import org.elasticsearch.client.transport.TransportClient;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuan
 * @Date: 2018/12/26 10:33
 * @Description:
 */
@Service
public class SearchServiceImpl implements ISearchService {

    private static final Logger logger = LoggerFactory.getLogger(ISearchService.class);

    private static final String INDEX_NAME = "xunwu";
    private static final String INDEX_TYPE = "house";
    private static final String INDEX_TOPIC = "house_build";

    private final HouseRepository houseRepository;
    private final HouseDetailRepository houseDetailRepository;
    private final HouseTagRepository tagRepository;
    private final SupportAddressRepository supportAddressRepository;
    private final IAddressService addressService;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final TransportClient esClient;

    @Autowired
    public SearchServiceImpl(HouseRepository houseRepository, HouseDetailRepository houseDetailRepository,
                             HouseTagRepository tagRepository, SupportAddressRepository supportAddressRepository,
                             IAddressService addressService, ModelMapper modelMapper, ObjectMapper objectMapper,
                             TransportClient esClient) {
        this.houseRepository = houseRepository;
        this.houseDetailRepository = houseDetailRepository;
        this.tagRepository = tagRepository;
        this.supportAddressRepository = supportAddressRepository;
        this.addressService = addressService;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.esClient = esClient;
    }

    @Override
    public void index(Long houseId) {

    }

    @Override
    public void remove(Long houseId) {

    }

    @Override
    public ServiceMultiResult<Long> query(RentSearch rentSearch) {
        return null;
    }

    @Override
    public ServiceResult<List<String>> suggest(String prefix) {
        return null;
    }

    @Override
    public ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district) {
        return null;
    }

    @Override
    public ServiceMultiResult<HouseBucketDTO> mapAggregate(String cityEnName) {
        return null;
    }

    @Override
    public ServiceMultiResult<Long> mapQuery(String cityEnName, String orderBy, String orderDirection, int start, int size) {
        return null;
    }

    @Override
    public ServiceMultiResult<Long> mapQuery(MapSearch mapSearch) {
        return null;
    }
}
