package com.github.frapontillo.pulse.crowd.tag.tagme;

import java.util.List;

/**
 * @author Francesco Pontillo
 */
public class TagMeResponse {
    private List<TagMeAnnotation> annotations;

    public List<TagMeAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<TagMeAnnotation> annotations) {
        this.annotations = annotations;
    }

    public class TagMeAnnotation {
        private String title;
        private Double rho;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getRho() {
            return rho;
        }

        public void setRho(Double rho) {
            this.rho = rho;
        }

        public boolean isRhoHigherThan(Double minRho) {
            return (minRho == null || rho >= minRho);
        }
    }
}
