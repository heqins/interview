public class Redis分布式锁伪代码 {
    /**
     * ValueOperations valueOperations=stringRedisTemplate.opsForValue();
     * Boolean cacheRes=valueOperations.setIfAbsent(key,value); //lua脚本提供“分布式锁服务”，就可以写在一起
     *             //TODO:redis部署节点宕机了
     *             if (cacheRes){
     *                 stringRedisTemplate.expire(key,30, TimeUnit.SECONDS);
     *
     *                 try {
     *                     ItemKill itemKill=itemKillMapper.selectByIdV2(killId);
     *                     if (itemKill!=null && 1==itemKill.getCanKill() && itemKill.getTotal()>0){
     *                         int res=itemKillMapper.updateKillItemV2(killId);
     *                         if (res>0){
     *                             commonRecordKillSuccessInfo(itemKill,userId);
     *
     *                             result=true;
     *                         }
     *                     }
     *                 }catch (Exception e){
     *                     throw new Exception("还没到抢购日期、已过了抢购时间或已被抢购完毕！");
     *                 }finally {
     *                     if (value.equals(valueOperations.get(key).toString())){
     *                         stringRedisTemplate.delete(key);
     *                     }
     */
}
