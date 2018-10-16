/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

package com.learn.Moblie;
   /***
   * @Description： 消费信息
                    包含卡号：CardNumber
                    消费类型：ConsumeType
                    消费数据：ConsumerCount
             
   * @Param:
   * @Return:
   * @Auther: Gavincoder
   * @Date: 2018/9/16
   */
public class ConsumInfo {
        private int CardNumber;
       private String ConsumeType;
       private int  ConsumerCount;

       public int getCardNumber() {
           return CardNumber;
       }

       public void setCardNumber(int cardNumber) {
           CardNumber = cardNumber;
       }

       public String getConsumeType() {
           return ConsumeType;
       }

       public void setConsumeType(String consumeType) {
           ConsumeType = consumeType;
       }

       public int getConsumerCount() {
           return ConsumerCount;
       }

       public void setConsumerCount(int consumerCount) {
           ConsumerCount = consumerCount;
       }
   }
