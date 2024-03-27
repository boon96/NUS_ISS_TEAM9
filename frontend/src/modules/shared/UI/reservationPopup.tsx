import React, { useEffect, useState } from "react";
import { Button, Modal } from 'antd';

const ConfirmationModal = (props) => {


  const [isModalVisible, setIsModalVisible] = useState(props.isVisible);


  useEffect(() => {
    setIsModalVisible(props.isVisible);
  }, [props.isVisible]);
  
  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    if (props.onConfirm) {
      props.onConfirm();
    }
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    if (props.onCancel) {
      props.onCancel();
    }
    setIsModalVisible(false);
  };

  return (
    <Modal
      title="Confirm Action"
      // visible={isModalVisible}
      open={isModalVisible}
      onOk={handleOk}
      onCancel={handleCancel}
      destroyOnClose  // This prop ensures the modal content is destroyed when closed
    >
      <p>{props.message}</p>
    </Modal>
  );
};

export default ConfirmationModal;
