//package com.wukong.core.generator.service;
//
//import com.wukong.core.generator.config.GeneratorConfig;
//
///**
// * Created by fanhl on 2016/7/1.
// */
//public class ServiceInterfaceInfo implements ServiceInfo{
//
//    private DaoBeanInfo daoBeanInfo;
//    private String packageName;
//    private String path;
//
//    public ServiceInterfaceInfo(DaoBeanInfo aDaoBeanInfo,String aPackageName,String aPath){
//        daoBeanInfo=aDaoBeanInfo;
//        packageName=aPackageName;
//        path=aPath;
//    }
//
//    public String getBeanName(){
//        String str= daoBeanInfo.getName();
//        str=str.substring(0,str.length()-"Mapper".length());
//        return "I"+str+"Service";
//    }
//
//    public String getPackageName(){
//        return packageName;
//    }
//
//
//
//    /**
//     * 不包含.java后缀的名称
//     * @return
//     */
//    public String getFileName(){
//        return path+"/"+getBeanName();
//    }
//
//    public String toString(){
//        StringBuffer sb= new StringBuffer();
//        sb.append(getPackgeStr());
//        sb.append(getImportStr());
//        sb.append(getClassStr());
//        sb.append(getMethodsStr());
//        sb.append(getEndStr());
//        return sb.toString();
//    }
//
//    /**
//     * 得到packgae语句
//     * @return
//     */
//    private  String getPackgeStr(){
//        String str= "package "+packageName +";\n\n";
//        return str;
//    }
//
//    /**
//     * 得到import语句
//     * @return
//     */
//    private  String getImportStr(){
//        StringBuffer sb= new StringBuffer();
//        for(String e:this.daoBeanInfo.getImports()){
//            sb.append(e);
//        }
//        sb.append("\n");
//        return sb.toString();
//    }
//
//    /**
//     * 得到Class的定义
//     * @return
//     */
//    private String getClassStr(){
//        String str= "public interface "+getBeanName()+" {\n";
//        return str;
//    }
//
//
//    /**
//     * 得到函数定义
//     * @return
//     */
//    private String getMethodsStr(){
//        StringBuffer sb= new StringBuffer();
//        for(String e:this.daoBeanInfo.getMethods()){
//            sb.append(getMethodComment());
//            sb.append(GeneratorConfig.getIndent());
//            sb.append(e);
//            sb.append("\n\n");
//        }
//        return sb.toString();
//    }
//
//
//    //得到函数的注释
//    private String getMethodComment(){
//        StringBuffer sb= new StringBuffer();
//        String s=GeneratorConfig.getIndent();
//        sb.append(s).append("/**").append("\n");
//        sb.append(s).append(" * ").append("This method was generated by ServiceInterfaceInfo Generator.").append("\n");
//        sb.append(s).append(" * ").append("@wkgenerated").append("\n");
//        sb.append(s).append(" */").append("\n");
//        return sb.toString();
//    }
//
//
//    /**
//     * 得到结尾
//     * @return
//     */
//    private String getEndStr(){
//        return "}";
//    }
//
//
//}