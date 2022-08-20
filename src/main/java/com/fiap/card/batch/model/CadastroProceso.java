package com.fiap.card.batch.model;

public class CadastroProceso {
        private String codigoCausa;
        private String dataInicioCausa;
        private String cpfConPartePrincipal;
        private String nomeConPartePrincipal;
        private String numeroProcesso;
        private String assunto;
        private String esfera;
        private String nomeProPartePrincipal;
        private String carteira;
        private String unidadeFederacao;
        private String dataFimProcesso;
        private String motivoStatus;
        private String produto;
        private String indenizavel;
        private String recurso;
        private String dataCadastroCausa;
        
        public String getCodigoCausa() {
            return codigoCausa;
        }
        public void setCodigoCausa(String codigoCausa) {
            this.codigoCausa = codigoCausa;
        }
        public String getDataInicioCausa() {
            return dataInicioCausa;
        }
        public void setDataInicioCausa(String dataInicioCausa) {
            this.dataInicioCausa = dataInicioCausa;
        }
        public String getCpfConPartePrincipal() {
            return cpfConPartePrincipal;
        }
        public void setCpfConPartePrincipal(String cpfConPartePrincipal) {
            this.cpfConPartePrincipal = cpfConPartePrincipal;
        }
        public String getNomeConPartePrincipal() {
            return nomeConPartePrincipal;
        }
        public void setNomeConPartePrincipal(String nomeConPartePrincipal) {
            this.nomeConPartePrincipal = nomeConPartePrincipal;
        }
        public String getNumeroProcesso() {
            return numeroProcesso;
        }
        public void setNumeroProcesso(String numeroProcesso) {
            this.numeroProcesso = numeroProcesso;
        }
        public String getAssunto() {
            return assunto;
        }
        public void setAssunto(String assunto) {
            this.assunto = assunto;
        }
        public String getEsfera() {
            return esfera;
        }
        public void setEsfera(String esfera) {
            this.esfera = esfera;
        }
        public String getNomeProPartePrincipal() {
            return nomeProPartePrincipal;
        }
        public void setNomeProPartePrincipal(String nomeProPartePrincipal) {
            this.nomeProPartePrincipal = nomeProPartePrincipal;
        }
        public String getCarteira() {
            return carteira;
        }
        public void setCarteira(String carteira) {
            this.carteira = carteira;
        }
        public String getUnidadeFederacao() {
            return unidadeFederacao;
        }
        public void setUnidadeFederacao(String unidadeFederacao) {
            this.unidadeFederacao = unidadeFederacao;
        }
        public String getDataFimProcesso() {
            return dataFimProcesso;
        }
        public void setDataFimProcesso(String dataFimProcesso) {
            this.dataFimProcesso = dataFimProcesso;
        }
        public String getMotivoStatus() {
            return motivoStatus;
        }
        public void setMotivoStatus(String motivoStatus) {
            this.motivoStatus = motivoStatus;
        }
        public String getProduto() {
            return produto;
        }
        public void setProduto(String produto) {
            this.produto = produto;
        }
        public String getIndenizavel() {
            return indenizavel;
        }
        public void setIndenizavel(String indenizavel) {
            this.indenizavel = indenizavel;
        }
        public String getRecurso() {
            return recurso;
        }
        public void setRecurso(String recurso) {
            this.recurso = recurso;
        }
        public String getDataCadastroCausa() {
            return dataCadastroCausa;
        }
        public void setDataCadastroCausa(String dataCadastroCausa) {
            this.dataCadastroCausa = dataCadastroCausa;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
            result = prime * result + ((carteira == null) ? 0 : carteira.hashCode());
            result = prime * result + ((codigoCausa == null) ? 0 : codigoCausa.hashCode());
            result = prime * result + ((cpfConPartePrincipal == null) ? 0 : cpfConPartePrincipal.hashCode());
            result = prime * result + ((dataCadastroCausa == null) ? 0 : dataCadastroCausa.hashCode());
            result = prime * result + ((dataFimProcesso == null) ? 0 : dataFimProcesso.hashCode());
            result = prime * result + ((dataInicioCausa == null) ? 0 : dataInicioCausa.hashCode());
            result = prime * result + ((esfera == null) ? 0 : esfera.hashCode());
            result = prime * result + ((indenizavel == null) ? 0 : indenizavel.hashCode());
            result = prime * result + ((motivoStatus == null) ? 0 : motivoStatus.hashCode());
            result = prime * result + ((nomeConPartePrincipal == null) ? 0 : nomeConPartePrincipal.hashCode());
            result = prime * result + ((nomeProPartePrincipal == null) ? 0 : nomeProPartePrincipal.hashCode());
            result = prime * result + ((numeroProcesso == null) ? 0 : numeroProcesso.hashCode());
            result = prime * result + ((produto == null) ? 0 : produto.hashCode());
            result = prime * result + ((recurso == null) ? 0 : recurso.hashCode());
            result = prime * result + ((unidadeFederacao == null) ? 0 : unidadeFederacao.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CadastroProceso other = (CadastroProceso) obj;
            if (assunto == null) {
                if (other.assunto != null)
                    return false;
            } else if (!assunto.equals(other.assunto))
                return false;
            if (carteira == null) {
                if (other.carteira != null)
                    return false;
            } else if (!carteira.equals(other.carteira))
                return false;
            if (codigoCausa == null) {
                if (other.codigoCausa != null)
                    return false;
            } else if (!codigoCausa.equals(other.codigoCausa))
                return false;
            if (cpfConPartePrincipal == null) {
                if (other.cpfConPartePrincipal != null)
                    return false;
            } else if (!cpfConPartePrincipal.equals(other.cpfConPartePrincipal))
                return false;
            if (dataCadastroCausa == null) {
                if (other.dataCadastroCausa != null)
                    return false;
            } else if (!dataCadastroCausa.equals(other.dataCadastroCausa))
                return false;
            if (dataFimProcesso == null) {
                if (other.dataFimProcesso != null)
                    return false;
            } else if (!dataFimProcesso.equals(other.dataFimProcesso))
                return false;
            if (dataInicioCausa == null) {
                if (other.dataInicioCausa != null)
                    return false;
            } else if (!dataInicioCausa.equals(other.dataInicioCausa))
                return false;
            if (esfera == null) {
                if (other.esfera != null)
                    return false;
            } else if (!esfera.equals(other.esfera))
                return false;
            if (indenizavel == null) {
                if (other.indenizavel != null)
                    return false;
            } else if (!indenizavel.equals(other.indenizavel))
                return false;
            if (motivoStatus == null) {
                if (other.motivoStatus != null)
                    return false;
            } else if (!motivoStatus.equals(other.motivoStatus))
                return false;
            if (nomeConPartePrincipal == null) {
                if (other.nomeConPartePrincipal != null)
                    return false;
            } else if (!nomeConPartePrincipal.equals(other.nomeConPartePrincipal))
                return false;
            if (nomeProPartePrincipal == null) {
                if (other.nomeProPartePrincipal != null)
                    return false;
            } else if (!nomeProPartePrincipal.equals(other.nomeProPartePrincipal))
                return false;
            if (numeroProcesso == null) {
                if (other.numeroProcesso != null)
                    return false;
            } else if (!numeroProcesso.equals(other.numeroProcesso))
                return false;
            if (produto == null) {
                if (other.produto != null)
                    return false;
            } else if (!produto.equals(other.produto))
                return false;
            if (recurso == null) {
                if (other.recurso != null)
                    return false;
            } else if (!recurso.equals(other.recurso))
                return false;
            if (unidadeFederacao == null) {
                if (other.unidadeFederacao != null)
                    return false;
            } else if (!unidadeFederacao.equals(other.unidadeFederacao))
                return false;
            return true;
        }
        @Override
        public String toString() {
            return "CadastroProceso [assunto=" + assunto + ", carteira=" + carteira + ", codigoCausa=" + codigoCausa
                    + ", cpfConPartePrincipal=" + cpfConPartePrincipal + ", dataCadastroCausa=" + dataCadastroCausa
                    + ", dataFimProcesso=" + dataFimProcesso + ", dataInicioCausa=" + dataInicioCausa + ", esfera="
                    + esfera + ", indenizavel=" + indenizavel + ", motivoStatus=" + motivoStatus
                    + ", nomeConPartePrincipal=" + nomeConPartePrincipal + ", nomeProPartePrincipal="
                    + nomeProPartePrincipal + ", numeroProcesso=" + numeroProcesso + ", produto=" + produto
                    + ", recurso=" + recurso + ", unidadeFederacao=" + unidadeFederacao + "]";
        }




}
