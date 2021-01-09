package club.lightingsummer.seckill.seckill.controller;

import club.lightingsummer.seckill.seckill.dto.Exposer;
import club.lightingsummer.seckill.seckill.dto.SeckillExecution;
import club.lightingsummer.seckill.seckill.dto.SeckillQueryResult;
import club.lightingsummer.seckill.seckill.exception.SeckillException;
import club.lightingsummer.seckill.seckill.model.Good;
import club.lightingsummer.seckill.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(name = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Good> seckillList = seckillService.getSeckilList();
        model.addAttribute("list", seckillList);
        return "list";
    }

    @RequestMapping(name = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Good seckillGood = seckillService.getSeckillById(seckillId);
        if (seckillGood == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckillGood", seckillGood);
        return "detail";
    }

    @RequestMapping(name = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillQueryResult<Exposer> expose(@PathVariable("seckillId") Long seckillId) {
        SeckillQueryResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillQueryResult<Exposer>(true, exposer);
        } catch (Exception e) {
            result = new SeckillQueryResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(name = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillQueryResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                        @PathVariable("md5") String md5,
                                                        @CookieValue(value = "killPhone", required = false) Long phone) {
        SeckillQueryResult<SeckillExecution> result;
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
            result = new SeckillQueryResult<SeckillExecution>(true, seckillExecution);
        } catch (SeckillException e) {
            result = new SeckillQueryResult<SeckillExecution>(false, e.getMessage());
        }
        return result;
    }
}
