package pard.secondSeminar.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    @RequestMapping("/log-test")
    public String logtest() {
        String name = "YSH";

        System.out.println("name =" + name);
        log.info("info log={}", name);
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        log.info("wrong log =", name);

        return "ok";
    }
}
