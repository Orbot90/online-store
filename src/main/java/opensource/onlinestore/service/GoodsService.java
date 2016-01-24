package opensource.onlinestore.service;

import opensource.onlinestore.model.dto.GoodsDTO;
import opensource.onlinestore.model.entity.CategoryEntity;

import java.util.List;

public interface GoodsService {
    boolean addGoods(GoodsDTO goodsDTO);

    List<GoodsDTO> getGoods(CategoryEntity category);
}
