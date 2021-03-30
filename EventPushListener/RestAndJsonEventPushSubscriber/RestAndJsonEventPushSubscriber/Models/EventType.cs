namespace RestAndJsonEventPushSubscriber.Models
{
    /// <summary>
    /// The types of events that can be subscribed to.
    /// </summary>
    public enum EventType : int
    {
        /// <summary>
        /// When a new folder is created.
        /// </summary>
        FileCreated = 0,

        /// <summary>
        /// When a folder gets completed.
        /// </summary>
        FileCompleted = 1,

        /// <summary>
        /// When a folder gets reassigned to a different signer.
        /// </summary>
        FileReassigned = 2,

        /// <summary>
        /// When a folder expires.
        /// </summary>
        FileExpired = 3,

        /// <summary>
        /// When a comment is added to a folder.
        /// </summary>
        StreamCommentAdded = 4,

        /// <summary>
        /// When a signature document is added to a folder.
        /// </summary>
        AgreementCreated = 5,

        /// <summary>
        /// When a signature document gets a signature.
        /// </summary>
        AgreementSigned = 6,

        /// <summary>
        /// When a signature document has been signed by all necessary signers.
        /// </summary>
        AgreementCompleted = 7,

        /// <summary>
        /// When a signature document expires.
        /// </summary>
        AgreementExpired = 8,

        /// <summary>
        /// When an individual signature document gets assigned to a different signer.
        /// </summary>
        RequestReassigned = 9,

        /// <summary>
        /// When a signer declines to sign a signature document.
        /// </summary>
        SignerDeclined = 10,

        /// <summary>
        /// When a signer or CC gets invited to sign a document in or view a folder.
        /// </summary>
        UserInvited = 11,

        /// <summary>
        /// When a signer or CC visits a folder.
        /// </summary>
        UserVisited = 12,

        /// <summary>
        /// When a payment fails processing.
        /// </summary>
        PaymentFailed = 13,

        /// <summary>
        /// When a payment completes.
        /// </summary>
        PaymentReceived = 14,

        /// <summary>
        /// When a payment gets refunded.
        /// </summary>
        PaymentRefunded = 15,

        /// <summary>
        /// When a payment gets deleted.
        /// </summary>
        PaymentRemoved = 16,
    }
}