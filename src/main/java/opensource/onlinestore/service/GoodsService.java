package opensource.onlinestore.service;

import opensource.onlinestore.model.entity.GoodsEntity;

import java.util.List;

public interface GoodsService {

    GoodsEntity create(GoodsEntity entity);

    GoodsEntity update(GoodsEntity entity);

    void delete(Long id);

    GoodsEntity findById(Long id);

    List<GoodsEntity> findAll();

}
