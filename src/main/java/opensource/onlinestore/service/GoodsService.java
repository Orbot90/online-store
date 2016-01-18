package opensource.onlinestore.service;

import opensource.onlinestore.model.Category;
import opensource.onlinestore.model.dto.GoodsDTO;

import java.util.List;

public interface GoodsService {
    boolean addGoods(GoodsDTO goodsDTO);

    List<GoodsDTO> getGoods(Category category);
}
