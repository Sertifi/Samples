namespace RestAndJsonEventPushSubscriber.Models
{
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name = "EventType", Namespace = "http://apps.sertifi.net/services/subscribers")]
    public enum EventType : int
    {
        /// <summary>
        /// When a new folder is created.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        FileCreated = 0,

        /// <summary>
        /// When a folder gets completed.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        FileCompleted = 1,

        /// <summary>
        /// When a folder gets reassigned to a different signer.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        FileReassigned = 2,

        /// <summary>
        /// When a folder expires.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        FileExpired = 3,

        /// <summary>
        /// When a comment is added to a folder.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        StreamCommentAdded = 4,

        /// <summary>
        /// When a signature document is added to a folder.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        AgreementCreated = 5,

        /// <summary>
        /// When a signature document gets a signature.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        AgreementSigned = 6,

        /// <summary>
        /// When a signature document has been signed by all necessary signers.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        AgreementCompleted = 7,

        /// <summary>
        /// When a signature document expires.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        AgreementExpired = 8,

        /// <summary>
        /// When an individual signature document gets assigned to a different signer.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        RequestReassigned = 9,

        /// <summary>
        /// When a signer declines to sign a signature document.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        SignerDeclined = 10,

        /// <summary>
        /// When a signer or CC gets invited to sign a document in or view a folder.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        UserInvited = 11,

        /// <summary>
        /// When a signer or CC visits a folder.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        UserVisited = 12,

        /// <summary>
        /// When a payment fails processing.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        PaymentFailed = 13,

        /// <summary>
        /// When a payment completes.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        PaymentReceived = 14,

        /// <summary>
        /// When a payment gets refunded.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        PaymentRefunded = 15,

        /// <summary>
        /// When a payment gets deleted.
        /// </summary>
        [System.Runtime.Serialization.EnumMemberAttribute()]
        PaymentRemoved = 16,
    }
}