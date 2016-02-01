package opensource.onlinestore.service;

import opensource.onlinestore.model.dto.GoodsDTO;
import opensource.onlinestore.model.entity.CategoryEntity;
import opensource.onlinestore.model.entity.GoodsEntity;

import java.util.List;

public interface GoodsService {

    boolean addGoods(GoodsDTO goodsDTO);

    List<GoodsDTO> getGoods(CategoryEntity category);

    GoodsEntity save(GoodsEntity entity);

    GoodsEntity update(GoodsEntity entity);

    void delete(Long id);

    GoodsEntity get(Long id);

    List<GoodsEntity> getAll();
}
