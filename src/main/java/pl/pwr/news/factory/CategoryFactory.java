package pl.pwr.news.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pwr.news.converter.ValueConverter;
import pl.pwr.news.model.category.Category;
import pl.pwr.news.model.tag.Tag;
import pl.pwr.news.service.category.CategoryService;

import java.util.List;

/**
 * Created by jf on 4/1/16.
 */
@Component
public class CategoryFactory {

    @Autowired
    CategoryService categoryService;

    public Category getInstance(String name, String imageUrl, List<Tag> tags) {
        Category existingCategory = categoryService.findByName(name);
        if (existingCategory != null) {
            return existingCategory;
        }
        Category newCategory = new Category(ValueConverter.convertCategoryName(name));
        newCategory.setImageUrl(imageUrl);
        tags.forEach(tag -> newCategory.addTag(tag));
        return newCategory;
    }
}