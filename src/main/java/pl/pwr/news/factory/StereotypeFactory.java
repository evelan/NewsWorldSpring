package pl.pwr.news.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pwr.news.converter.ValueConverter;
import pl.pwr.news.model.stereotype.Stereotype;
import pl.pwr.news.service.stereotype.StereotypeService;

/**
 * Created by jf on 4/1/16.
 */
@Component
public class StereotypeFactory {

    @Autowired
    StereotypeService stereotypeService;

    public Stereotype getInstance(String name, String imageUrl) {
        Stereotype existingStereotype = stereotypeService.findByName(name);
        if (existingStereotype != null) {
            return existingStereotype;
        }
        Stereotype newStereotype = new Stereotype(ValueConverter.convertStereotypeName(name));
        newStereotype.setImageUrl(imageUrl);
        return newStereotype;
    }
}