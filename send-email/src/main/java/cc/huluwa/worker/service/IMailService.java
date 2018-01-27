package cc.huluwa.worker.service;

import cc.huluwa.worker.model.Email;

public interface IMailService {

    /**
     * 纯文本
     *
     * @param mail
     * @throws Exception void
     * @Author hxy
     * @Date 2018年1月25日
     */
    public void send(Email mail) throws Exception;

    /**
     * 附件
     * @param mail
     * @throws Exception void
     * @Author hxy
     * @Date 2018年1月25日
     */
    public void sendAffix(Email mail) throws Exception;

    /**
     * freemarker
     * @Author hxy
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
    public void sendFreemarker(Email mail)throws Exception;

    /**
     * thymeleaf
     * @Author hxy
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
    public void sendThymeleaf(Email mail)throws Exception;

    /**
     *  图片
     * @Author hxy
     * @param mail
     * @throws Exception  void
     * @Date 2018年1月25日
     */
    public void sengImg(Email mail) throws Exception;
}
