package albert.practice.failsafe;

public class ConnParams {
    private String url;
    private String userName;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private ConnParams(Builder builder) {
        this.url = builder.url;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    @Override
    public String toString() {
        return "ConnParams [url=" + url + ", userName=" + userName + ", password=" + password + "]";
    }

    public static class Builder {

        private String url;
        private String userName;
        private String password;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public ConnParams build() {
            return new ConnParams(this);
        }
    }

}
