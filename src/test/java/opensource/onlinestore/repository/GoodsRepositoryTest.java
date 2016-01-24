package opensource.onlinestore.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import opensource.onlinestore.configuration.TestAppConfig;
import opensource.onlinestore.model.Category;
import opensource.onlinestore.model.entity.CategoryEntity;
import opensource.onlinestore.model.entity.GoodsEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
public class GoodsRepositoryTest {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void prepare() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(Category.ELECTRONICS);
        categoryRepository.save(categoryEntity);
    }

    @Test
    public void shouldWrightAnEntity() throws JsonProcessingException {
        CategoryEntity categoryEntity = categoryRepository.findByName(Category.ELECTRONICS);
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setName("SuperMegaTestGood");
        goodsEntity.setProducer("USSR UltraMegaTech");
        goodsEntity.setCategory(categoryEntity);
        goodsEntity.setCount(1L);
        goodsEntity.setPrice(666D);
        Map<String, String> stats = new HashMap<>();
        stats.put("firstparameter", "lolgreat");
        stats.put("secondparameter", "notsogreat");
        goodsEntity.setCharachteristicsFromMap(stats);
        goodsRepository.save(goodsEntity);
        GoodsEntity recoveredEntity = goodsRepository.findByName(goodsEntity.getName());
        Assert.assertEquals(goodsEntity, recoveredEntity);
    }

}