package opensource.onlinestore.service.impl;

import opensource.onlinestore.model.dto.GoodsDTO;
import opensource.onlinestore.model.entity.CategoryEntity;
import opensource.onlinestore.model.entity.GoodsEntity;
import opensource.onlinestore.repository.GoodsRepository;
import opensource.onlinestore.service.GoodsService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Logger LOG = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private Mapper beanMapper;

    //todo: implement all this stuff

    @Override
    public boolean addGoods(GoodsDTO goodsDTO) {
        return true;
    }

    @Override
    public List<GoodsDTO> getGoods(CategoryEntity category) {
        return null;
    }

    @Override
    public GoodsEntity save(GoodsEntity entity) {
        return goodsRepository.saveAndFlush(entity);
    }

    @Override
    public GoodsEntity update(GoodsEntity entity) {
        return goodsRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.delete(id);
    }

    @Override
    public GoodsEntity get(Long id) {
        return goodsRepository.findOne(id);
    }

    @Override
    public List<GoodsEntity> getAll() {
        return goodsRepository.findAll();
    }


}
