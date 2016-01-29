package opensource.onlinestore.service.impl;

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
    private GoodsRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public GoodsEntity create(GoodsEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public GoodsEntity update(GoodsEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }


    @Override
    public GoodsEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<GoodsEntity> findAll() {
        return repository.findAll();
    }

}
