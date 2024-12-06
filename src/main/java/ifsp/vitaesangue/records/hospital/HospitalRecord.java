package ifsp.vitaesangue.records.hospital;


import ifsp.vitaesangue.model.TipoHospital;
import ifsp.vitaesangue.records.estabelecimento.EstabelecimentoRecord;

public record HospitalRecord(String cnes, TipoHospital tipo,  String diretorResponsavel, EstabelecimentoRecord estabelecimento) {
	
}
