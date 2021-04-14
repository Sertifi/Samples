using System;
using Microsoft.AspNetCore.Mvc;
using RestAndJsonEventPushSubscriber.Models;

namespace RestAndJsonEventPushSubscriber.Controllers
{
    [Route("v1/notifications")]
    [ApiController]
    public class EventPushSubscriberController : ControllerBase
    {
        /// <summary>
        /// This is the method that the Sertifi Event Push will call.
        /// </summary>
        /// <param name="notificationEvent">The event notification information that has been subscribed to.</param>
        /// <returns>A REST response otherwise Sertifi will not know the notification was received and will try sending it again.</returns>
        [HttpPost]
        [Consumes("application/json")]
        public IActionResult ReceiveNotification([FromBody] NotificationEvent notificationEvent)
        {
            throw new NotImplementedException();
            
            //return new OkResult(); // after the notification has been processed, please let us know that you got it.
        }
        
        // GET
        public IActionResult TestGet()
        {
            return new OkResult();
        }
    }
}