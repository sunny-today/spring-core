package hello.core.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class ProxyImpl implements Proxy {
    @Override
    public String execute() {
        return "success";
    }

    @Override
    public String test() {
        return "test";
    }
}
