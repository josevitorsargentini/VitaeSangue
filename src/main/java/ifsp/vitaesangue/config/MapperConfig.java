package ifsp.vitaesangue.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ifsp.vitaesangue.records.bolsasangue.requisicao.BolsaRequisicaoResponse;
import ifsp.vitaesangue.records.hemocentro.HemocentroIdentificacaoResponse;
import ifsp.vitaesangue.records.hospital.HospitalIdentificacaoResponse;
import ifsp.vitaesangue.records.usuario.UsuarioUpdate;
import ifsp.vitaesangue.model.BolsaRequisicao;
import ifsp.vitaesangue.model.Hemocentro;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.Requisicao;
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
          
          modelMapper.addMappings(new PropertyMap<Hospital, HospitalIdentificacaoResponse>() {
              @Override
              protected void configure() {
                  // Mapeia o nome para nomeEstabelecimento
                  map(source.getEstabelecimento().getNome(), destination.getNome());
              }
          });
          
          modelMapper.addMappings(new PropertyMap<Hemocentro, HemocentroIdentificacaoResponse
        		  >() {
              @Override
              protected void configure() {
                  // Mapeia o nome para nomeEstabelecimento
                  map(source.getEstabelecimento().getNome(), destination.getNome());
              }
          });
         
          
          return modelMapper;
    }
}