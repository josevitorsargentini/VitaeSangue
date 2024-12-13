package ifsp.vitaesangue.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ifsp.vitaesangue.records.usuario.UsuarioUpdate;
import ifsp.vitaesangue.model.Usuario;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
    	  ModelMapper modelMapper = new ModelMapper();
          
          modelMapper.getConfiguration()
              .setMatchingStrategy(MatchingStrategies.STRICT)
              .setDeepCopyEnabled(false)
              .setSkipNullEnabled(true);
          
          modelMapper.addMappings(new PropertyMap<UsuarioUpdate, Usuario>() {
              @Override
              protected void configure() {
                  skip(destination.getEstabelecimento());
                  skip(destination.getPerfil());
              }
          });
          
          return modelMapper;
    }
}