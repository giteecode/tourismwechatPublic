
import {config} from '../../request/config'
import {request} from '../../request/index.js'
const app = getApp()
const appG = app.globalData;
Page({
  data: {
    ZhuceyonghuList:[]
  },
  onLoad: function () {
  },
  hsgadd(){
    wx.navigateTo({
      url: '/pages/Zhuceyonghuadd/index'
    });
  },
  onShow:function(){
    let user = wx.getStorageSync('user');
    if (!user) {
      	wx.showToast({
        title: '请先登录',
        icon: 'none'
      }) 
      wx.navigateTo({
        url: '/pages/login/index'
      });
    } 
	else {
    }
    this.getAdminTextInfoList();
    },
    getAdminTextInfoList() {
      let user = wx.getStorageSync('user');
      request({url: '/zhuceyonghuInfo'}).then(res => {
          if(res.code === '0') {
              let ZhuceyonghuList = res.data;
              ZhuceyonghuList.forEach(item => {
                if(!item.zhaopian || item.zhaopian === '[]') {
                    item.url = this.data.defaultImageUrl;
                } else {
                    let fileArr = JSON.parse(item.zhaopian)
                    item.url = config.baseFileUrl + fileArr[0];
                }
               
            });
              this.setData({
                ZhuceyonghuList,
              })
          } else {
              wx.showToast({
                  title: res.msg,
                  icon: 'none'
              })
          }
      })
    },
	hsgdetail: function (e) {
      const { id } = e.currentTarget.dataset;
      wx.navigateTo({
        url: '/pages/zhuceyonghudetail/index?id='+id,
      });
    },
    hsgshanchu: function (e) {
      const { id } = e.currentTarget.dataset;
      wx.showModal({
        content: '您是否要删除？',
        success: (res) => {
          if (res.confirm) {
            let user = wx.getStorageSync("user");
            request({url: '/zhuceyonghuInfo/' + id, method: 'DELETE'}).then(res => {
              if (res.code === '0') {
                wx.showToast({
                  title: '删除成功',
                  icon: 'none'
                })
                this.getAdminTextInfoList();
              } else {
                wx.showToast({
                  title: res.msg,
                  icon: 'error'
                })
              }
            })
          }
        }
      })
     
    },
})