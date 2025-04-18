package ols2405.tacocloud.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ols2405.tacocloud.Ingredient;
import ols2405.tacocloud.Taco;

@Slf4j
@Repository
public class JdbcTacoRepository implements TacoRepository {

    private final JdbcTemplate jdbc;

    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        log.info("**************************" + taco);
        // for (Ingredient ingredient : taco.getIngredients()) {
        //     saveIngredientToTaco(ingredient, tacoId);
        // }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        log.info("**************************" + taco);
        PreparedStatementCreatorFactory preparedStatementCreatorFactory = new PreparedStatementCreatorFactory("insert into Taco(name, createdAt) values (?,?)", Types.VARCHAR, Types.TIMESTAMP);

        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);
        
        PreparedStatementCreator psc = preparedStatementCreatorFactory.newPreparedStatementCreator(
                Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        log.info("************************** " + keyHolder.getKey());
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)", tacoId, ingredient.getId());
    }
}
